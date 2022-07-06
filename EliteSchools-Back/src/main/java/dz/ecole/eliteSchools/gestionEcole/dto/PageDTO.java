package dz.ecole.eliteSchools.gestionEcole.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {
    private List<T> content;
    private long number;
    private long size;
    private long totalElements;
    private long totalPages;
}
