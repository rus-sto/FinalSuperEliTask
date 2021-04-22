package starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import starter.model.entity.Information;
import starter.model.service.ServiceDataBase;


@RestController// это позволяет работать в формате Json . Тут можем написать общий ЮРЛ для всех эндпоинтов которые будут
@RequestMapping("/names")  // Общая площадка для всяких tanya  и  ivan  ,т.е. для всех эндпоинтов по дефолту
public class HelloMomController {


    private final ServiceDataBase serviceDataBase;

    @Autowired
    public HelloMomController(ServiceDataBase serviceDataBase) {
        this.serviceDataBase = serviceDataBase;
    }
//    @Autowired
//    private final GoogleSheetsController googleSheetsController;


    @GetMapping("/tanya") // это мой эндпоинт
    public String findFirst(@RequestParam(value = "name", defaultValue = "World") String name,
                            @RequestParam(value = "hear", defaultValue = "mama1") String hear) {

        System.out.println(" try test " + name + " " + hear);

        serviceDataBase.findAllFromDataBase();
        return "hi, Andrew" + name + " " + hear;
    }


    @GetMapping("/info") // это мой эндпоинт
    public Information findSecond(@RequestParam(value = "StringInfo", required = false) String name) {

//        public String findSecond(@RequestParam(value = "StringInfo", required = false) String name) {
        Information information = new Information();
        information.setInfo(name);

        serviceDataBase.saveInformation(information);
        System.out.println(" try test #2 " + name + " ");

        return information;
        /*
        http://localhost:8080/names/ivan?name=RUS&hear=Pasha-GOOd   - это запрос в строке браузера
        hi, PashaRUS Pasha-GOOd  - это ответ прогрммы
         */
    }


//    @GetMapping("/The") // это мой эндпоинт
//    public List<Information> theOne() throws IOException, GeneralSecurityException {
//        System.out.println(" from database");
//        List<Information> myList = serviceDataBase.findAllFromDataBase();
//        googleSheetsController.methodForUpdate("1H8XZkhUn_z10k-7RcWFQt3QEJ-llPwiI3Gx8t9wMOMQ", "A1", myList);
//        return myList;
//    }
}
