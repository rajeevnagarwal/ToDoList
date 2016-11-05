package com.example.rajeevnagarwal.todolist;

import java.util.UUID;

/**
 * Created by Rajeev Nagarwal on 11/2/2016.
 */

public class Item {
    private UUID mId;
    private String mTitle;
    private String mDescription;
    public Item()
    {
        mId = UUID.randomUUID();
    }
    public UUID getId()
    {
        return this.mId;
    }
    public String getTitle()
    {
        return this.mTitle;
    }
    public String getDescription()
    {
        return this.mDescription;
    }
    public void setTitle(String title)
    {
        this.mTitle = title;
    }
    public void setDescription(String description)
    {
        this.mDescription = description;
    }






}
