package com.yaomy.sgrain.common.utils.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description:文件系统通用程序工具类
 * @Version: 1.0
 */
@SuppressWarnings("all")
public class FileSystemUtils {
    /**
     * 返回此抽象路径名指定的分区上可用于此虚拟机的字节数，
     * @param path 路径名称
     * @return 可用于虚拟机的字节数
     */
    public static long getUsableSpace(String path){
        try {
            return Files.getFileStore(Paths.get(path)).getUsableSpace();
        } catch (IOException e){
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 返回文件系统中未分配存储空间的字节数
     * @param path 路径名称
     * @return 可用于虚拟机的字节数
     */
    public static long getUnallocatedSpace(String path){
        try {
            return Files.getFileStore(Paths.get(path)).getUnallocatedSpace();
        } catch (IOException e){
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 文件系统对应的总的字节数
     * @param path 路径名称
     * @return 可用于虚拟机的字节数
     */
    public static long getTotalSpace(String path){
        try {
            return Files.getFileStore(Paths.get(path)).getTotalSpace();
        } catch (IOException e){
            e.printStackTrace();
            return 0L;
        }
    }

    /**
     * 判断文件存储是否只读
     * @param path 路径名称
     * @return true 只读，false 不可读
     */
    public static boolean isReadOnly(String path){
        try {
            return Files.getFileStore(Paths.get(path)).isReadOnly();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
