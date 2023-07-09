package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;

public interface AvatarService {
    Avatar uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatarById (Long studentId);
}
