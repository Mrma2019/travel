package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.entity.Travel;
import top.pymrma.boot.repository.TravelRepository;
import top.pymrma.boot.services.FileService;
import top.pymrma.boot.services.TravelService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final FileService fileService;

    @Transactional
    @Override
    public boolean createTravel(Travel travel, MultipartFile file) throws IOException {
        String coverUrl = fileService.upload(file);
        travel.setCoverUrl(coverUrl);
        Travel savedTravel = travelRepository.save(travel);
        return savedTravel.getId() != null;
    }

    @Override
    public PageResult<Travel> queryAllTravels(Pageable pageable) {
        PageResult<Travel> result = PageResult.of(travelRepository.findAll(pageable));
        return result;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            travelRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
