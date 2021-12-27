package edu.dl.project01.service;

import edu.dl.project01.domain.item.Item;
import edu.dl.project01.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }
    public Item findOne(Long id){
        return itemRepository.findOne(id);
    }
    public List<Item> findItems(){
        return itemRepository.findAll();
    }
}
