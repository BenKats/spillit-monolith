package com.project.repository;


import com.project.model.User;
import com.project.model.UserProfile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class UserProfileRepositoryStub implements UserProfileRepository {

    @Override
    public UserProfile findUserProfilesByUser(User user) {
        return null;
    }

    @Override
    public List<UserProfile> findAll() {
        return null;
    }

    @Override
    public List<UserProfile> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UserProfile> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserProfile> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(UserProfile userProfile) {

    }

    @Override
    public void deleteAll(Iterable<? extends UserProfile> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends UserProfile> S save(S entity) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("ben@gmail.com");
        userProfile.setMobile("914-000-1233");

        return (S)userProfile;
    }


    @Override
    public <S extends UserProfile> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<UserProfile> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends UserProfile> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<UserProfile> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UserProfile getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends UserProfile> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UserProfile> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UserProfile> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UserProfile> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UserProfile> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UserProfile> boolean exists(Example<S> example) {
        return false;
    }
}
