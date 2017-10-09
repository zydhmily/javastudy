import java.net.URLEncoder;
import java.net.URLDecoder;

public class EncodeAndDecode {
    public static void main(String[] args) throws Exception {
        //google网站的url
        String url = "https://www.google.co.jp/?gfe_rd=cr&dcr=0&ei=U2fbWY_vOfCQ8QewuaOYBA";
        //将url转换成encode编码
        String encodeUrl = java.net.URLEncoder.encode(url,"UTF-8");
        //打印转换后url
        System.out.println(encodeUrl);
        //将encode编码url转换成decode编码
        String decodeUrl = java.net.URLDecoder.decode(encodeUrl,"UTF-8");
        //打印转换后url
        System.out.println(decodeUrl);
    }
}