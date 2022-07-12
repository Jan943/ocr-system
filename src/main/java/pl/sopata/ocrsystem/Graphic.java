package pl.sopata.ocrsystem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@NoArgsConstructor
public class Graphic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Getter
//    @Setter
    @JsonIgnore
    private Long id;
    private String url;
    private String content;

    public Graphic() {
    }

    public Graphic(String url, String content) {
        this.url = url;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
