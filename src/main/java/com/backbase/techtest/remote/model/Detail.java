package com.backbase.techtest.remote.model;

public class Detail {
	
	private Balance new_balance;
    private String description;
    private Balance value;
    private String type;
    private String posted;
    private String completed;

    public Balance getNew_balance ()
    {
        return new_balance;
    }

    public void setNew_balance (Balance new_balance)
    {
        this.new_balance = new_balance;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Balance getValue ()
    {
        return value;
    }

    public void setValue (Balance value)
    {
        this.value = value;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPosted ()
    {
        return posted;
    }

    public void setPosted (String posted)
    {
        this.posted = posted;
    }

    public String getCompleted ()
    {
        return completed;
    }

    public void setCompleted (String completed)
    {
        this.completed = completed;
    }
}
