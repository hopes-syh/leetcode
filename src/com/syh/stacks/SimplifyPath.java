package com.syh.stacks;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 18-8-25
 * Time: 下午9:58
 * To change this template use File | Settings | File Templates.
 */
public class SimplifyPath {

    public static void main(String[] args) throws InterruptedException {
        SimplifyPath path = new SimplifyPath();

        System.out.println(path.simplifyPath("/home/"));
        System.out.println(path.simplifyPath("/a/./b/../../c/"));
        System.out.println(path.simplifyPath("/../"));
        System.out.println(path.simplifyPath("/home//foo/"));
        System.out.println(path.simplifyPath("/abc/..."));
    }

    public String simplifyPath(String path) {
        if(path.equals("/")){
            return path;
        }

        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        for(String p : paths){
            if("".equals(p) || ".".equals(p)){
                continue;
            }

            if("..".equals(p) && stack.size() > 0){
                stack.pop();
            }
            else if(!"..".equals(p)){
                stack.push(p);
            }
        }

        StringBuilder buffer = new StringBuilder();
        Object[] newpaths = stack.toArray();
        for(int i=0; i<=newpaths.length-1; i++){
            buffer.append("/");
            buffer.append(newpaths[i]);
        }
        if(newpaths.length <= 0){
            buffer.append("/");
        }
        return buffer.toString();
    }
}
