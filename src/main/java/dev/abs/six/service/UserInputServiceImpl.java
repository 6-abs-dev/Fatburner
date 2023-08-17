package dev.abs.six.service;


import dev.abs.six.model.ProductDTO;
import dev.abs.six.repository.UserInputRepository;
import dev.abs.six.repository.UserInputRepositoryImpl;

public class UserInputServiceImpl {

//    @Inject
    private UserInputRepository userInputRepository = new UserInputRepositoryImpl();

    public ProductDTO getTest() {
        return userInputRepository.saveNewInput();
    }
}
