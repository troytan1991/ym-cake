package com.troytan.ymcake.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;


public class HtmlUtils {
    private static String url = "https://blog.csdn.net/wsyw126/article/details/74853680";  
    
    //workspace folder.  
    private static String workspace = "download";  
      
    //sub css and js resources sign   
    private static String urlSign = "<link href=";  
      
    //sub image resources sign  
    private static String urlSign2 = "src=";  
      
    //URL parent.  
    private static String rootUrl = null;  
  
    public static void main (String[] args) throws Exception  
    {  
        long start = System.nanoTime ();  
        setRootUrl ();  
        URL u = new URL (url);  
        InputStream is = u.openStream ();  
        BufferedReader reader = new BufferedReader (new InputStreamReader (is));  
        File f = createDownloadFile ("download.html");  
        BufferedWriter writer = new BufferedWriter (new FileWriter (f));  
        String s;  
        while ((s = reader.readLine ()) != null)  
        {  
            writer.write (s);  
            writer.newLine ();  
            if (hasSubUrl (s))  
            {  
                downloadChild (getSubUrl (s));  
            }  
        }  
        is.close ();  
        reader.close ();  
        writer.close ();  
        System.out.println ("Download time(s):" + String.format ("%.3f", (double)(System.nanoTime () - start)/ 1000000000.00));  
    } // end of main  
  
    /** 
     * set root url for the downloading html 
     */  
    private static void setRootUrl ()  
    {  
        int pos = url.lastIndexOf ("/");  
        rootUrl = url.substring (0, pos);  
        System.out.println ("Root Url is:" + rootUrl);  
    }  
  
    /** 
     * check if content includes sub resources. 
     *  
     * @param text line of html content. 
     * @return Yes or Not 
     */  
    private static boolean hasSubUrl (String text)  
    {  
        if (StringUtils.isNotEmpty (text))  
        {  
            if (text.contains (urlSign) || text.contains (urlSign2))  
            {  
                return true;  
            }  
            return false;  
        }  
        else  
        {  
            return false;  
  
        }  
  
    }  
  
    /** 
     * generate sub url from line content. 
     */  
    private static String getSubUrl (String text)  
    {  
        int pos = text.indexOf (urlSign);  
        pos = (pos == -1) ? text.indexOf (urlSign2) : pos;  
        text = text.substring (pos);  
        String[] ps = text.split ("\"");  
        System.out.println ("subUrl is :" + ps[1]);  
        return ps[1];  
    }  
  
    /** 
     * download sub resources,<b>Note: don't use Java Character Writers, 
     * otherwise you can't get pictures correctly.</b> 
     *  
     * @param subUrl 
     */  
    private static void downloadChild (String subUrl)  
    {  
        if (StringUtils.isNotEmpty (subUrl))  
        {  
            if (subUrl.startsWith ("http:"))  
            {  
                System.out.println ("subUrl not support yet.");  
            }  
            else  
            {  
                long start = System.nanoTime ();  
                try  
                {  
                    String forUrl = subUrl.replace (" ", "%20");  
                    if (!forUrl.startsWith ("/"))  
                    {  
                        forUrl = "/" + forUrl;  
                    }  
                    URL u = new URL (rootUrl + forUrl);  
                    InputStream reader = u.openStream ();  
                    File f = createDownloadFile (subUrl);  
                    FileOutputStream writer = new FileOutputStream (f);  
                    byte[] buff = new byte[1024];  
                    int size = -1;  
                    while ((size = reader.read (buff)) != -1)  
                    {  
                        writer.write (buff, 0, size);  
  
                    }  
                    reader.close ();  
                    writer.close ();  
                }  
                catch (Exception e)  
                {  
                    e.printStackTrace ();  
                }  
                System.out.println ("Source:" + subUrl +"download time(s):" + String.format ("%.3f", (double)(System.nanoTime () - start)/ 1000000000.00));  
            }  
        }  
        else  
        {  
            System.out.println ("subUrl is Empty.");  
  
        }  
    }  
  
    /** 
     * create sub file,create parent folders if necessary. 
     *  
     * @param url related path of a url source. 
     * @return created file. 
     */  
    private static File createDownloadFile (String url)  
    {  
        File f = new File (workspace, url);  
        f.getParentFile ().mkdirs ();  
        return f;  
    }  
  
}
