package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(max = 100)
    private String name;
    @NotEmpty
    @Size(max = 100)
    private String url;
    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9 ]*")
    private String description;
    private Date date;
    @ManyToOne
    private Creator creator;
}
