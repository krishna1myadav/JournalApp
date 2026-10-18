//package com.springboot.journalApp.service;
//
//import com.springboot.journalApp.entity.User;
//import com.springboot.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testFindByUserName(){
//        User user = userRepository.findByUserName("mohan");
//        assertTrue(!user.getJournalEntries().isEmpty());
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1, 3, 4",
//            "2, 5, 7",
//            "3, 8, 10"
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a + b);
//
//    }
//}
