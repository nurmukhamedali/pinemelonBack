package kz.pinemelon.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonDeserialize(as = Category.class)
public abstract class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String name;
    protected String description;
    protected String image;
    protected boolean enabled;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonBackReference
    protected Category category;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}
    public boolean isEnabled() {return enabled;}
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}
    public LocalDateTime getUpdateDate() {return updateDate;}
    public void setUpdateDate(LocalDateTime updateDate) {this.updateDate = updateDate;}
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public void addComponent(Component component){
        throw new UnsupportedOperationException("Cannot add item to catalog.");
    }
    public void removeComponent(Component component){
        throw new UnsupportedOperationException("Cannot remove item from catalog.");
    }
}
