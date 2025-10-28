package com.veluz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_data")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String categoryName;
    private String description;
    private String icon;
    private String name;
    private String routerPath;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRouterPath() { return routerPath; }
    public void setRouterPath(String routerPath) { this.routerPath = routerPath; }
}
