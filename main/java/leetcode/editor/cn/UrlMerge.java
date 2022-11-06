package leetcode.editor.cn;

/**
 * 给定 URL 的前后缀，诸如 /abc/,/def （以英文逗号分隔），
 * 输出合并结果如 /abc/def （结果进行中间分隔符的去重）
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/27
 */
public class UrlMerge {

    private String merge(String url){

        if (url == null || "".equals(url.trim())) {
            return null;
        }
        if(!url.contains(",")){
            return url;
        }
        String[] split = url.split(",");
        if(split.length !=2){
            throw new RuntimeException("输入参数有误");
        }
        if(split[0].endsWith("/") && split[1].startsWith("/")){
            return split[0].substring(0,split[0].length()-1)+split[1];
        }
        if(!split[0].endsWith("/") && !split[1].startsWith("/")){
            return split[0]+"/"+split[1];
        }


        return split[0] + split[1];
    }

    public static void main(String[] args) {
        String merge = new UrlMerge().merge("/abc,def");
        System.out.println(merge);
    }
}
