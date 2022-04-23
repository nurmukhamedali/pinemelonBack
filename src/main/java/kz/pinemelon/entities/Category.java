package kz.pinemelon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category extends Component {
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Component> components;

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public void addComponent(Component component){
        this.components.add(component);
    }

    @Override
    public void removeComponent(Component component){
        this.components.add(component);
    }
}
