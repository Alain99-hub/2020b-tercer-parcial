package oop.exams.repository;

import oop.exams.exception.BadRegionException;
import oop.exams.model.Region;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LicensePlatesRepositoryTest {

        @Test
        public void givenAState_whenGetRegionByState_ThenReturnAState(){
            //given:
            LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
            final Map<String, Region> regionByState = new HashMap<>();
            final EnumMap<Region, Set<String>> licensePlatesByRegion = new EnumMap<>(Region.class);
            String state= "SLP";
            //when:
            Region region= licensePlateRepository.getRegionByState(state);
            //then:
            assertThat(region).isEqualTo(Region.CENTER);

        }

    @Test
    public void givenANoState_whenGetRegionByState_ThenThrowAException(){
        //given:
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
        final Map<String, Region> regionByState = new HashMap<>();
        final EnumMap<Region, Set<String>> licensePlatesByRegion = new EnumMap<>(Region.class);
        String state= "XDX";
        //when:
       // Region region= licensePlateRepository.getRegionByState(state);
        //then:
        assertThatThrownBy(() -> licensePlateRepository.getRegionByState(state))
                .isInstanceOf(BadRegionException.class).hasMessage("Estado desconocido");

    }


    public void givenARegion_whenCountByRegion_ThenReturnzice(){
        //given:
        LicensePlateRepository licensePlateRepository = new LicensePlateRepository();
         Map<String, Region> regionByState = new HashMap<>();

        EnumMap<Region, Integer> licensePlatesByRegion =new EnumMap<>(Region.class);
         licensePlatesByRegion.put(Region.CENTER, 1);
        licensePlatesByRegion.put(Region.NORTH, 2);
        licensePlatesByRegion.put(Region.EAST, 3);
        licensePlatesByRegion.put(Region.WEST, 4);
        licensePlatesByRegion.put(Region.SOUTH, 5);



        int size;
        Region region = Region.CENTER;
          //when:
         size=licensePlateRepository.countByRegion(region);
        //then:

        assertThat(size).isEqualTo(5);

    }

    @Test
    public void givenARegionAndLicensePlate_whenSave_ThenLicensePlatesByRegion(){
        //given:
        LicensePlateRepository licensePlateRepository = Mockito.mock(LicensePlateRepository.class);
        final Map<String, Region> regionByState = new HashMap<>();
        final EnumMap<Region, Set<String>> licensePlatesByRegion = new EnumMap<>(Region.class);
        String state= "SLPXD";
        Region region = Region.WEST;

        //when:
         licensePlateRepository.save(region,state);
        //then:


    }
}
