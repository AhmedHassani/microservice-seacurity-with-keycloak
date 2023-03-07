package com.iraqsofit.speedoo.controller;
import com.iraqsofit.speedoo.models.*;
import com.iraqsofit.speedoo.repository.NotificationRepository;
import com.iraqsofit.speedoo.service.AddressServer;
import com.iraqsofit.speedoo.service.HomeAppService;
import com.iraqsofit.speedoo.service.NotificationService;
import com.iraqsofit.speedoo.service.UserDateilsService;
import com.iraqsofit.speedoo.user.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/gemstone/v1")
@RestController
public class HomeAppController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserDateilsService userDateilsService;
    @Autowired
    private HomeAppService homeAppService;

    @Autowired
    private AddressServer addressServer;
    //privacy
    //About
    @GetMapping("/about")
    public PrivacyOrAboutModel about (){
        return  new PrivacyOrAboutModel("2022-12-31","هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع. ومن هنا وجب على المصمم أن يضع نصوصا مؤقتة على التصميم ليظهر للعميل الشكل كاملاً،دور مولد النص العربى أن يوفر على المصمم عناء البحث عن نص بديل لا علاقة له بالموضوع الذى يتحدث عنه التصميم فيظهر بشكل لا يليق. هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.\n");
    }

    @GetMapping("/privacy")
    public PrivacyOrAboutModel privacy (){
        return  new PrivacyOrAboutModel("2022-12-30","هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق. إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع. ومن هنا وجب على المصمم أن يضع نصوصا مؤقتة على التصميم ليظهر للعميل الشكل كاملاً،دور مولد النص العربى أن يوفر على المصمم عناء البحث عن نص بديل لا علاقة له بالموضوع الذى يتحدث عنه التصميم فيظهر بشكل لا يليق. هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.\n");
    }

    @GetMapping("/category")
    public Response GetCategory(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(2,"Category1","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160253.png?alt=media&token=9f380bd4-a574-497b-81bb-ea4c22bf7b81"));
        categoryList.add(new Category(3,"Category2","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160333.png?alt=media&token=169999f6-b0f5-4f7a-8494-0fe1f605cadd"));
        categoryList.add(new Category(4,"Category3","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160253.png?alt=media&token=9f380bd4-a574-497b-81bb-ea4c22bf7b81"));
        categoryList.add(new Category(5,"Category4","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160333.png?alt=media&token=169999f6-b0f5-4f7a-8494-0fe1f605cadd"));
        categoryList.add(new Category(6,"Category5","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160253.png?alt=media&token=9f380bd4-a574-497b-81bb-ea4c22bf7b81"));
        categoryList.add(new Category(7,"Category6","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160333.png?alt=media&token=169999f6-b0f5-4f7a-8494-0fe1f605cadd"));
        return new Response<>(
                true,
                categoryList,
                "success",
                200
        );
    }

    @GetMapping("/banners")
    public Response GetBanners(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Banner1","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160131.png?alt=media&token=e35de842-6d23-4e3f-b7f1-35275d8a3545"));
        categoryList.add(new Category(1,"Banner2","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160131.png?alt=media&token=e35de842-6d23-4e3f-b7f1-35275d8a3545"));
        categoryList.add(new Category(1,"Banner3","https://firebasestorage.googleapis.com/v0/b/dsas-5e504.appspot.com/o/Screenshot%202023-01-31%20160131.png?alt=media&token=e35de842-6d23-4e3f-b7f1-35275d8a3545"));
        return new Response<>(
                true,
                categoryList,
                "success",
                200
        );
    }


    @GetMapping("/notification/{username}")
    public Response getNotification(@PathVariable String username){

        List<NotificationModel> notificationModelList1 = new ArrayList<>();
        notificationModelList1.add(new NotificationModel("وصول الطلب","الطلب قيد التوصيل رقم الطلب 34",0,"c07aa8c0-a6cd-438c-a1c4-7d09239e73f7"));
        notificationModelList1.add(new NotificationModel("تأكيد الطلب","الطلب رقم 12345 قد تم تأكيده. لمشاهدة التفاصيل اضغط هنا",1,"52d0c0ea-a0cd-4c97-996f-a406434b5595"));
        notificationModelList1.add(new NotificationModel("إلغاء الطلب","الطلب رقم 12345 قد تم إلغاؤه. لمشاهدة التفاصيل اضغط هنا",2,"8a05702c-a5d2-4cc8-9d89-69e3119d830f"));
        NotificationDateModel notificationDateModel1 =new NotificationDateModel("2023-02-23 12:07:12",notificationModelList1);
        NotificationDateModel notificationDateModel2 =new NotificationDateModel("2023-02-24 1:07:12",notificationModelList1);
        NotificationDateModel notificationDateModel3 =new NotificationDateModel("2023-02-25 1:07:12",notificationModelList1);
        NotificationDateModel notificationDateModel4 =new NotificationDateModel("2023-02-26 1:07:12",notificationModelList1);
        List<NotificationDateModel> notifications = new ArrayList<>();
        notifications.add(notificationDateModel1);
        notifications.add(notificationDateModel2);
        notifications.add(notificationDateModel3);
        notifications.add(notificationDateModel4);

        return new Response<>(
                true,
                notifications,
                "success",
                200
        );
    }

    @GetMapping("/notification/push/")
    public ResponseEntity pushNotification(){
        return notificationService.sentNotification("093c1896-71df-406c-9768-99c1a5a5b2b4",false);
    }

    @GetMapping(value = {"/getPosts","/getPosts/"})
    public ResponseEntity getPosts(
                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(homeAppService.getPost(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping(value = {"/getEducational","/getEducational/"})
    public ResponseEntity getEducational(
            @RequestHeader("key") String key,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        if(!key.equals("6f19456a-123e-4f4b-beaf-188fa54fe7bc")){
            return new ResponseEntity(new Response(false,
                    new ArrayList<>(),"Please contact us to activate the account",
                    402), HttpStatus.PAYMENT_REQUIRED);
        }
        return new ResponseEntity(homeAppService.getEducational(pageNo,pageSize,sortBy), HttpStatus.OK);
    }


    @PostMapping("/add/posts")
    public ResponseEntity addPosts(@RequestBody Posts posts) {
        return new ResponseEntity(homeAppService.addPost(posts), HttpStatus.CREATED);
    }

    @PostMapping("/add/educational")
    public ResponseEntity addEducational(@RequestBody Educational educational) {
        return new ResponseEntity(homeAppService.addEducational(educational), HttpStatus.CREATED);
    }


    @GetMapping("/address/{username}")
    public  List<AddressInfo> getAddress(@PathVariable String username){
        return addressServer.getAddressByUserID(username);
    }

    @PostMapping("/add/address")
    public ResponseEntity addAddress(@RequestBody AddressInfo address) {
        return new ResponseEntity(addressServer.save(address), HttpStatus.CREATED);
    }


}
