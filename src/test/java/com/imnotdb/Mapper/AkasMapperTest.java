package com.imnotdb.Mapper;

import com.imnotdb.Entity.Akas;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.nutz.dao.QueryResult;

@Slf4j
public class AkasMapperTest {

    @Test
    public void getAkasByNameTest(){
        AkasMapper akasMapperbak = new AkasMapper();
        String name = "你好";
        QueryResult queryResult = akasMapperbak.getAkasByName(name, 1, 25, true);
        for (Akas akas : queryResult.getList(Akas.class)) {
            log.info(akas.toString());
        }
        log.info("pageCount: {}", queryResult.getPager().getPageCount());
        log.info("recordSize: {}", queryResult.getPager().getRecordCount());
        for(int i = 0; i < 10 && queryResult.getPager().hasNext();i++){
            queryResult = akasMapperbak.getAkasByName(name, queryResult.getPager().getPageNumber() + 1, queryResult.getPager().getPageSize(), true);
            for (Akas akas : queryResult.getList(Akas.class)) {
                System.out.println(akas);
            }
        }
    }
    @Test
    public void getAkasByTconstTest(){
        AkasMapper akasMapperbak = new AkasMapper();
        String tconst = "tt9418812";
        QueryResult queryResult = akasMapperbak.getAkasByTconst(tconst, 0, 0, true);
        for (Akas akas : queryResult.getList(Akas.class)) {
            log.info(akas.toString());
        }
    }
    @Test
    public void getAkasByRegion(){
        AkasMapper akasMapper = new AkasMapper();
        String region = "JP";
        QueryResult queryResult = akasMapper.getAkasByRegion(region, 1, 20, true);
        for (Akas akas : queryResult.getList(Akas.class)) {
            log.info(akas.toString());
        }
        queryResult = akasMapper.getAkasByRegion(region, 2, 20, false);
        for (Akas akas : queryResult.getList(Akas.class)) {
            log.info(akas.toString());
        }
    }
    @Test
    public void getAkasByNameAndRegionTest(){
        AkasMapper akasMapper = new AkasMapper();
        String region = "JP";
        String name = "可能";
        QueryResult queryResult = akasMapper.getAkasByRegionAndName(region, name, 1, 20, true);
        for (Akas akas : queryResult.getList(Akas.class)) {
            log.info(akas.toString());
        }
        queryResult = akasMapper.getAkasByRegionAndName(region,name, queryResult.getPager().getPageNumber()+1, queryResult.getPager().getPageSize(), false);
        for (Akas akas : queryResult.getList(Akas.class)) {
            log.info(akas.toString());
        }
    }
}
