package hi.cryptocurrencyapi.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;
    private Integer version;
    private Date dateCreated;
    private Date dateUpdated;

    @Id
    @GenericGenerator(name = "sequenceGenerator", strategy = "enhanced-sequence", parameters = {
            @Parameter(name = "prefer_sequence_per_entity", value = "true"),
            @Parameter(name = "optimizer", value = "pooled-lo"),
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "10")
    })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @CreationTimestamp
    @Column(name = "dateCreated")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @UpdateTimestamp
    @Column(name = "dateUpdated")
    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && this.getClass() == o.getClass() && (o instanceof BaseEntity && (id != null) ? id.equals(((BaseEntity) o).id) : (o == this));
    }

    @Override
    public int hashCode() {
        return id != null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }
}
