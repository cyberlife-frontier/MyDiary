package com.example.mydiary;

public class Daily {
    private Integer id;
    private String title;
    private String createtime;
    private String content;
    private String author;

    public Daily(){

    }

    public Daily(Integer id,String title,String createtime,String content,String author){
        this.id=id;
        this.title=title;
        this.createtime=createtime;
        this.content=content;
        this.author=author;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){return author;}

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  void setAuthor(String author){this.author = author;}

}
