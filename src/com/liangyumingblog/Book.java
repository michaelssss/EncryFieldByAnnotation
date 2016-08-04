
package com.liangyumingblog;


public class Book
{
    private String name;

    private String author;

    @SensitiveField(encryWay = "I Get Encry", decryWay = "I Got Decry")
    private String buyer;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getBuyer()
    {
        return buyer;
    }

    public void setBuyer(String buyer)
    {
        this.buyer = buyer;
    }

    @Override
    public String toString()
    {
        return "Book{" +
            "name='" + name + '\'' +
            ", author='" + author + '\'' +
            ", buyer='" + buyer + '\'' +
            '}';
    }
}
