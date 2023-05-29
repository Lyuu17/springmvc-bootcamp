package net.aspanc.bootcamp.springmvc.daos;

import net.aspanc.bootcamp.springmvc.entities.GameModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameDao extends PagingAndSortingRepository<GameModel, Long> {

    Page<GameModel> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
