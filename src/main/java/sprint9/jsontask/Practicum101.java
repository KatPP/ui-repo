package sprint9.jsontask;

import com.google.gson.Gson;

class Practicum101 {
    public static void main(String[] args) {
        UserPost post = new UserPost();
        post.setPhotoUrl("https://new-social-network.site/images/928476864.jpg");
        post.setUserId(97_748);
        post.setDescription("Классное фото!");
        post.setLikesQuantity(753);

        // создайте экземпляр Gson
        Gson gson = new Gson();
        // сериализуйте объект
        String postSerialized = gson.toJson(post);;
        System.out.println("Serialized post: " + postSerialized);

        // десериализуйте объект
        UserPost postDeserialized = gson.fromJson(postSerialized, UserPost.class);
        System.out.println("Deserialized post: " + postDeserialized);
    }
}


class UserPost {
    // URL-адрес, по которому можно скачать фото
    private String photoUrl;

    // уникальный идентификатор автора поста
    private int userId;

    // текстовый комментарий к фото
    private String description;

    // сколько пользователей поставило лайк этому посту
    private int likesQuantity;


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikesQuantity() {
        return likesQuantity;
    }

    public void setLikesQuantity(int likesQuantity) {
        this.likesQuantity = likesQuantity;
    }


    @Override
    public String toString() {
        return "UserPost{" +
                "photoUrl='" + photoUrl + '\'' +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", likesQuantity=" + likesQuantity +
                '}';
    }
}
