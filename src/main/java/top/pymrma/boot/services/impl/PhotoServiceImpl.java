package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.converter.PhotoConverter;
import top.pymrma.boot.entity.Photo;
import top.pymrma.boot.repository.PhotoRepository;
import top.pymrma.boot.services.FileService;
import top.pymrma.boot.services.PhotoService;
import top.pymrma.boot.vo.PhotoVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final FileService fileService;
    private final PhotoConverter photoConverter;


    @Override
    public boolean createPhotos(Photo photo, MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return false;
        }

        List<String> destPathList = fileService.upload(files);
        List<Photo> photos = new ArrayList<>();

        for (String path : destPathList) {
            Photo newPhoto = new Photo();
            BeanUtils.copyProperties(photo, newPhoto, "id", "url", "createdAt");
            newPhoto.setUrl(path);
            photos.add(newPhoto);
        }

        List<Photo> savedPhotos = photoRepository.saveAll(photos);
        return !savedPhotos.isEmpty();
    }

    @Override
    public PageResult<PhotoVO> queryAllPhotos(Pageable pageable) {
        Page<PhotoVO> photoPage =
                photoRepository.findAll(pageable)
                        .map(photoConverter::toVO);
        return PageResult.of(photoPage);
    }

    @Override
    public PageResult<PhotoVO> queryPhotosByTravelId(Pageable pageable, Long travelId) {
        Page<PhotoVO> photoPage =
                photoRepository.findPhotoByTravelId(pageable, travelId)
                        .map(photoConverter::toVO);
        return PageResult.of(photoPage);
    }
}
