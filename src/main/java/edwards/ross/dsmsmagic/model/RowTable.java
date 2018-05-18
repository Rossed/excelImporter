package edwards.ross.dsmsmagic.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "row")
@Data
public class RowTable implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "rowTable")
    private List<TableCell> cells;

    public RowTable() {}

    public RowTable(List<TableCell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return String.format("Row[id=%d, cells='%s']",
                id,
                cells);
    }
}
