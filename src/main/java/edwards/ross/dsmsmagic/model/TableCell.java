package edwards.ross.dsmsmagic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "table_cell")
@Data
public class TableCell {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "CELL_CONTENTS")
    private String contents;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROW_TABLE_ID")
    private RowTable rowTable;
}
