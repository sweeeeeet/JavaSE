package com.sweet.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件处理工具
 * <p>
 * Author: sweet
 * Created: 2018/10/13
 */
public final class FileUtil {


    private FileUtil() {
    }

    /**
     * 是否为Windows环境
     *
     * @return 是否为Windows环境
     */
    public static boolean isWindows() {
        //TODO
        return false;
    }

    /**
     * 列出目录文件<br>
     * 给定的绝对路径不能是压缩包中的路径
     *
     * @param path 目录绝对路径或者相对路径
     * @return 文件列表（包含目录）
     */
    public static File[] ls(String path) {
        if (!path.isEmpty()) {
            File file = Paths.get(path).toFile();
            if (file.exists()) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    File[] files = file.listFiles();
                    for (File f : files) {
                        ls(f.getPath());
                    }
                }
            }
        }
        return null;
    }

    /**
     * 目录是否为空
     *
     * @param dirPath 目录
     * @return 是否为空
     */
    public static boolean isDirEmpty(Path dirPath) {

        if (dirPath != null) {
            File file = dirPath.toFile();
            if (file.exists()) {
                if (file.isDirectory()) {
                    if (file.listFiles().length == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 获取标准的绝对路径
     *
     * @param file 文件
     * @return 绝对路径
     */
    public static String getAbsolutePath(File file) {
        if (file != null) {
            if (file.exists()) {
                String[] files = new String[512];
                int index = -1;

                while (file != null) {
                    if (file.getParent() == null) {
                        //提前检测是否到达顶层目录
                        files[++index] = file.getPath();
                        break;
                    }
                    files[++index] = file.getName();
                    file = file.getParentFile();
                }
                for (int i = index; i >= 0; i--) {
                    if (i == 0) {
                        System.out.print(files[i]);
                    } else {
                        System.out.print(files[i] + File.separator);

                    }
                }

            }
        }
        return null;
    }

    /**
     * 给定路径已经是绝对路径<br>
     * 此方法并没有针对路径做标准化
     *
     * @param path 需要检查的Path
     * @return 是否已经是绝对路径
     */
    public static boolean isAbsolutePath(String path) {
        //TODO
        if (path != null) {
            Path myPath = Paths.get(path);
            while (myPath != null) {
                myPath = myPath.getParent();

            }
        }
        return false;
    }


    /**
     * 递归遍历目录以及子目录中的所有文件<br>
     * 如果提供file为文件，直接返回过滤结果
     *
     * @param path       当前遍历文件或目录的路径
     * @param fileFilter 文件过滤规则对象，选择要保留的文件，只对文件有效，不过滤目录
     * @return 文件列表
     */
    public static List<File> loopFiles(String path, FileFilter fileFilter) {
        //TODO
        return new ArrayList<>();
    }


    /**
     * 获取临时文件路径（绝对路径）
     *
     * @return 临时文件路径
     */
    public static String getTmpDirPath() {
        //TODO
        return null;
    }

    /**
     * 获取用户路径（绝对路径）
     *
     * @return 用户路径
     */
    public static String getUserHomePath() {
        //TODO
        return null;
    }

    /**
     * 判断文件是否存在，如果file为null，则返回false
     *
     * @param file 文件
     * @return 如果存在返回true
     */
    public static boolean exist(File file) {
        if (file != null) {
            if (file.isDirectory() || file.isFile()) {
                return true;
            }
        }
        return false;
    }


    /**
     * 指定文件最后修改时间
     *
     * @param file 文件
     * @return 最后修改时间
     */
    public static Date lastModifiedTime(File file) {
        //TODO
        return null;
    }


    /**
     * 计算目录或文件的总大小<br>
     * 当给定对象为文件时，直接调用 {@link File#length()}<br>
     * 当给定对象为目录时，遍历目录下的所有文件和目录，递归计算其大小，求和返回
     *
     * @param file 目录或文件
     * @return 总大小，bytes长度
     */
    private static long length = 0;

    public static long size(File file) {
        if (file != null) {
            if (file.isFile()) {
                length += file.length();
            } else {
                for (File files : file.listFiles()) {
                    size(files);
                }
            }
            return length;
        }
        return -1;
    }

    /**
     * 给定文件或目录的最后修改时间是否晚于给定时间
     *
     * @param file      文件或目录
     * @param reference 参照文件
     * @return 是否晚于给定时间
     */
    public static boolean newerThan(File file, File reference) {
        //TODO
        return false;
    }

    /**
     * 给定文件或目录的最后修改时间是否晚于给定时间
     *
     * @param file       文件或目录
     * @param timeMillis 做为对比的时间
     * @return 是否晚于给定时间
     */
    public static boolean newerThan(File file, long timeMillis) {
        //TODO
        return false;
    }

    /**
     * 创建所给文件或目录的父目录
     *
     * @param file 文件或目录
     * @return 父目录
     */
    public static File mkParentDirs(File file) throws IOException {
        if (file != null) {
            if (!file.exists()) {
                file = file.getParentFile();
                file.mkdirs();
                return file;
            }
        }
            return null;
        }

        /**
         * 创建文件及其父目录，如果这个文件存在，直接返回这个文件<br>
         * 此方法不对File对象类型做判断，如果File不存在，无法判断其类型
         *
         * @param file 文件对象
         * @return 文件，若路径为null，返回null
         */
        public static File touch (File file){
            //TODO
            return null;
        }


        /**
         * 删除文件或者文件夹<br>
         * 注意：删除文件夹时不会判断文件夹是否为空，如果不空则递归删除子文件或文件夹<br>
         * 某个文件删除失败会终止删除操作
         *
         * @param file 文件对象
         * @return 成功与否
         */
        public static boolean del (File file){
            //TODO
            return false;
        }

        /**
         * 清空文件夹<br>
         * 注意：清空文件夹时不会判断文件夹是否为空，如果不空则递归删除子文件或文件夹<br>
         * 某个文件删除失败会终止删除操作
         *
         * @param directory 文件夹
         * @return 成功与否
         */
        public static boolean clean (File directory){
            //TODO
            return false;
        }


        /**
         * 移动文件或者目录
         *
         * @param src        源文件或者目录
         * @param dest       目标文件或者目录
         * @param isOverride 是否覆盖目标，只有目标为文件才覆盖
         */
        public static void move (File src, File dest,boolean isOverride){
            //TODO
        }

        /**
         * 修改文件或目录的文件名，不变更路径，只是简单修改文件名<br>
         * 重命名有两种模式：<br>
         * 1、isRetainExt为true时，保留原扩展名：
         *
         * <pre>
         * FileUtil.rename(file, "aaa", true) xx/xx.png =》xx/aaa.png
         * </pre>
         * <p>
         * 2、isRetainExt为false时，不保留原扩展名，需要在newName中
         *
         * <pre>
         * FileUtil.rename(file, "aaa.jpg", false) xx/xx.png =》xx/aaa.jpg
         * </pre>
         *
         * @param file        被修改的文件
         * @param newName     新的文件名，包括扩展名
         * @param isRetainExt 是否保留原文件的扩展名，如果保留，则newName不需要加扩展名
         * @param isOverride  是否覆盖目标文件
         * @return 目标文件
         */
        public static File rename (File file, String newName,boolean isRetainExt, boolean isOverride){
            //TODO
            return null;
        }


        /**
         * 文件路径是否相同<br>
         * 取两个文件的绝对路径比较，在Windows下忽略大小写，在Linux下不忽略。
         *
         * @param file1 文件1
         * @param file2 文件2
         * @return 文件路径是否相同
         */
        public static boolean pathEquals (File file1, File file2){
            //TODO
            return false;
        }


        /**
         * 获取文件扩展名，扩展名不带“.”
         *
         * @param file 文件
         * @return 扩展名
         */
        public static String extName (File file){
            //TODO
            return null;
        }


        /**
         * 获取指定层级的父路径
         *
         * <pre>
         * getParent(file("d:/aaa/bbb/cc/ddd", 0)) -> "d:/aaa/bbb/cc/ddd"
         * getParent(file("d:/aaa/bbb/cc/ddd", 2)) -> "d:/aaa/bbb"
         * getParent(file("d:/aaa/bbb/cc/ddd", 4)) -> "d:/"
         * getParent(file("d:/aaa/bbb/cc/ddd", 5)) -> null
         * </pre>
         *
         * @param file  目录或文件
         * @param level 层级
         * @return 路径File，如果不存在返回null
         */
        public static File getParent (File file,int level){
            //TODO
            return null;
        }

    }
