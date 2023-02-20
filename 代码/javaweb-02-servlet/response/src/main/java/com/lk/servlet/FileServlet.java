package com.lk.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         要获取下载文件的路径
        String realPath = "E:\\LearningNotes\\JAVA前端\\javaweb\\代码\\javaweb-02-servlet\\response\\target\\classes\\胡晓飞.png";
        System.out.println("下载的文件路径："+realPath);
//                 下载的文件名
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
//                 设置想办法让浏览器能够支持下载我们需要的东西,让中文文件名通过URLEncoder.encode编码，否则可能乱码
        resp.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
//                 获取下载文件的输入流

        FileInputStream in = new FileInputStream(realPath);
//                 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//                 获取OutoutStream对象
        ServletOutputStream out = resp.getOutputStream();
//                 将FileOutputStream流写入到Buffer缓冲区
        while ((len = in.read(buffer))>0){
            out.write(buffer,0,len);

        }
//                 使用OutputStream将缓冲区中的数据输出到客户端
        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
