package com.bawei.imageloader;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by yufuhao on 2017/4/27.
 */

public class IAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File ownCacheDirectory = StorageUtils.getOwnCacheDirectory(this, "imageloader / Cache");
        System.out.println("ownCacheDirectory" + ownCacheDirectory);
        //自定义ImageLoader的配置
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)//线程池中加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .diskCache(new UnlimitedDiskCache(ownCacheDirectory))
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 120 * 120)) //缓存到内存中
                .build();
        ImageLoader imageloader = ImageLoader.getInstance();
        imageloader.init(config);
    }

    public static DisplayImageOptions display() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)//加载图片的时候显示的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//没有图片的时候加载的图片
                .showImageOnFail(R.mipmap.ic_launcher)//加载失败时显示的图片
                .cacheInMemory(true)//启动内缓存
                .cacheOnDisk(true)//启动外缓存
                .considerExifParams(true)//启用EXIF和JPEG格式
                .displayer(new RoundedBitmapDisplayer(150))//设置圆角矩形
                .build();
        return options;
    }
}

