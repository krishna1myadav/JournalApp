//package com.springboot.journalApp.service;
//
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//import org.junit.jupiter.params.support.ParameterDeclarations;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.stream.Stream;
//
//public class UserArgumentsProvider implements ArgumentsProvider {
//    @Override
//    public Stream<? extends Arguments> provideArguments(ParameterDeclarations parameters, ExtensionContext context) throws Exception {
//        return Stream.of(
//                Arguments.of(User.builder().username("mohan").password("1234").build()),
//                Arguments.of(User.builder().username("shyam").password("").build())
//        );
//    }
//}
