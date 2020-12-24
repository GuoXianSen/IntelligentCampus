package action;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/UploadServletFile")
public class UploadServletFile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码为utf-8
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        FileItemFactory factory = new DiskFileItemFactory();

        // 文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析请求信息
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 对请求信息进行判断
        Iterator iter = items.iterator();
        String userimg = "";
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 信息为普通的格式
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String value = item.getString();
                request.setAttribute(fieldName, value);
            }
            // 信息为文件格式
            else {
                String fileName = item.getName();//获得上传图片的名称
                int index = fileName.lastIndexOf("\\");
                fileName = fileName.substring(index + 1);
//                request.setAttribute("realFileName", fileName);
                String basePath = request.getSession().getServletContext().getRealPath("/upload");
                System.out.println(basePath);//打印当前位置

                //使用UUID给图片重命名，并去掉四个“-”
                String name = UUID.randomUUID().toString().replaceAll("-", "");
                //获取文件的扩展名
                String ext = FilenameUtils.getExtension(fileName);
                fileName=name+"."+ext;
                userimg = "/upload/" + fileName;
                File file = new File(basePath, fileName);

                try {

                    item.write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        Result result = new Result();
        // 递交图片
        result.setResult("success");
        result.setMessage("上传完成");
        result.setImgUrl(userimg);
        JSONObject jso = new JSONObject();
        jso = JSONObject.fromObject(result);
        Writer out = response.getWriter();
        out.write(jso.toString()) ;
        out.flush();
        out.close();

    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
