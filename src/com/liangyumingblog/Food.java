
package com.liangyumingblog;

public class Food
{
    private String name;

    @SensitiveField(encryWay = "I Got Encry", decryWay = "I Got Decry")
    private String owner;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    @Override
    public String toString()
    {
        return "Food{" +
            "name='" + name + '\'' +
            ", owner='" + owner + '\'' +
            '}';
    }
}
