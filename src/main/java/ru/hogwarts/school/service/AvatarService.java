package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.exception.StudentIsNotFound;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.List;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatarById (Long studentId) throws StudentIsNotFound;
    List<Avatar> getAllAvatars(Integer pageNumber, Integer pageSize);
}
