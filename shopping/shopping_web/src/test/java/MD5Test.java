import org.springframework.util.DigestUtils;

public class MD5Test {
    //  一、spring 自带的 DigestUtils 工具类可以进行 md5 加密

    //导入包

    //对密码进行 md5 加密
    public static void  main(String[]args){
        String password = "123";
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5Password);

    }


}
