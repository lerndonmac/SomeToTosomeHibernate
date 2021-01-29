package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter@Setter@Entity@NoArgsConstructor@AllArgsConstructor
@Table(name = "books")
public class Books {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column(name = "publish_year")
    private String publishYear;

    @OneToOne
    @JoinColumn(name = "genre_id")
    private Genre genreId;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",

            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Authors> authors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_user",

            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Users> users;

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishYear='" + publishYear + '\'';
    }
}
