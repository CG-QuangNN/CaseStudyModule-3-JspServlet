package repository;

import java.util.List;

public interface IFindAllRepository<E> {
    List<E> findAll();
}