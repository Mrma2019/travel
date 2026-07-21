package top.pymrma.boot.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.pymrma.boot.common.PageResult;
import top.pymrma.boot.converter.TravelConverter;
import top.pymrma.boot.entity.Travel;
import top.pymrma.boot.repository.TravelRepository;
import top.pymrma.boot.services.FileService;
import top.pymrma.boot.services.TravelService;
import top.pymrma.boot.vo.TravelVO;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final FileService fileService;
    private final TravelConverter travelConverter;

    @Transactional
    @Override
    public boolean createTravel(Travel travel, MultipartFile file) throws IOException {
        String coverUrl = fileService.upload(file);
        travel.setCoverUrl(coverUrl);
        Travel savedTravel = travelRepository.save(travel);
        return savedTravel.getId() != null;
    }

    @Override
    public PageResult<TravelVO> queryAllTravels(Pageable pageable) {
        Page<TravelVO> map = travelRepository.findAll(pageable).map(travelConverter::toVO);
        return PageResult.of(map);
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
