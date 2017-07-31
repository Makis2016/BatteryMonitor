package com.furongsoft.Public.Model;

import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */
public class CombotreeData
{
    private Long id;
    private String text;
    private List<CombotreeData> children;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public List<CombotreeData> getChildren()
    {
        return children;
    }

    public void setChildren(List<CombotreeData> children)
    {
        this.children = children;
    }
}