package ru.Vadim.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Vadim.telegrambot.entities.Category;
import ru.Vadim.telegrambot.entities.Product;
import ru.Vadim.telegrambot.repositories.CategoryRepository;
import ru.Vadim.telegrambot.repositories.ProductRepository;

@SpringBootTest
 class FillingTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /** Метод для создания объекта основной категории */
    private void createMainCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        
    }

    /** Метод для создания объекта подкатегории */
    private void createSubCategory(String name, Category parent) {
        Category category = new Category();
        category.setName(name);
        category.setParent(parent);
        categoryRepository.save(category);
        
    }

    /** Метод для создания объекта товара */
    private void createProduct(Category category,String name, String desc,Double price){
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setDescription(desc);
        product.setPrice(price);
        productRepository.save(product);

    }


    @Test
     void createCategoryObjects() {

        // Основные категории

        createMainCategory("Пицца");

        createMainCategory("Роллы");

        createMainCategory("Бургеры");

        createMainCategory("Напитки");

        // Подкатегории Роллы

        createSubCategory("Классические роллы", categoryRepository.findByName("Роллы"));

        createSubCategory("Запеченные роллы", categoryRepository.findByName("Роллы"));

        createSubCategory("Сладкие роллы", categoryRepository.findByName("Роллы"));

        createSubCategory("Наборы роллов", categoryRepository.findByName("Роллы"));

        //Подкатегории Бургеры

        createSubCategory("Классические бургеры", categoryRepository.findByName("Бургеры"));

        createSubCategory("Острые бургеры", categoryRepository.findByName("Бургеры"));

        // Подкатегории напитки
        
        createSubCategory("Газированные напитки", categoryRepository.findByName("Напитки"));

        createSubCategory("Энергетические напитки", categoryRepository.findByName("Напитки"));

        createSubCategory("Соки", categoryRepository.findByName("Напитки"));

        createSubCategory("Другие", categoryRepository.findByName("Напитки"));

    }

    @Test
    void createProductObjects(){

        /* Товары категории пицца */
        
        createProduct(categoryRepository.findByName("Пицца"), "Эрдоган",
                "Бекон, сочная пепперони, сыр моцарелла, итальянские травы",479.00);

        createProduct(categoryRepository.findByName("Пицца"), "Неаполитана",
                "Томатный соус, молодая моцарелла, бекон, томаты черри, руккола",589.00);

        createProduct(categoryRepository.findByName("Пицца"), "Фиеста",
                "Сливочный соус, цыпленок, моцарелла, маслины, томаты черри, руккола",619.00);


        /* Товары категории роллы */
        /* Товары подкатегории Классические роллы */
        
        createProduct(categoryRepository.findByName("Классические роллы"), "Филадельфия",
                "Лосось, крем чиз, рис, нори",549.99);

        createProduct(categoryRepository.findByName("Классические роллы"), "Калифорния",
                "Икра, угорь, крем чиз, рис, нори",379.99);

        createProduct(categoryRepository.findByName("Классические роллы"), "Филадельфия креветка",
                "Лосось,креветка, крем чиз, рис, нори",599.00);

        /* Товары подкатегории Запеченные роллы */

        createProduct(categoryRepository.findByName("Запеченные роллы"), "Ямми",
                "Угорь, сырная шапка, рис, нори",300.99);

        createProduct(categoryRepository.findByName("Запеченные роллы"), "Темпура",
                "Креветка, крем чиз, рис, нори",400.50);

        createProduct(categoryRepository.findByName("Запеченные роллы"), "Огонек",
                "Сырная шапка, мидия, крем чиз, рис, нори",350.50);

        /* Товары подкатегории Сладкие роллы */

        createProduct(categoryRepository.findByName("Сладкие роллы"), "Шоколадный",
                "Клубника, крем чиз, белый шоколад",599.00);

        createProduct(categoryRepository.findByName("Сладкие роллы"), "Асьенда",
                "Смородиновый джем, крем чиз, темный шоколад",349.00);

        createProduct(categoryRepository.findByName("Сладкие роллы"), "Изысканный",
                "Рисовый пудинг, рисовая бумага, Бисквит, фруктовое желе",300.00);

        /* Товары подкатегории Наборы роллов */

        createProduct(categoryRepository.findByName("Наборы роллов"), "Все включено",
                "Вулкан, Типичный, Панко Мидия, Саламандр, Макото, Калифорния, " +
                        "Бонито, Ролл с лососем, Три сыра",2219.00);

        createProduct(categoryRepository.findByName("Наборы роллов"), "Твой",
                "Аляска лосось, запеченный чиз ролл, Хит",756.00);

        createProduct(categoryRepository.findByName("Наборы роллов"), "Сет в большом городе",
                "Роллы Хипстер, Тори хот, Запеченный чиз рол",1399.00);

        /* Товары категории Бургеры */
        /* Товары подкатегории Классические бургеры */

        createProduct(categoryRepository.findByName("Классические бургеры"), "Чизбургер",
                "Говяжья котлета, сыр, салат, соус",300.00);

        createProduct(categoryRepository.findByName("Классические бургеры"), "ШефБургер",
                "Свиная котлета, сыр чеддер, помидор, огурец, салат, соус от шефа",400.00);

        createProduct(categoryRepository.findByName("Классические бургеры"), "Детский",
                "Куриная котлетаа, помидор, салат Айсберг, маринованные огурцы, соус",250.15);

        /* Товары подкатегории Острые бургеры */

        createProduct(categoryRepository.findByName("Острые бургеры"), "АвтоРоял",
                "Говядина, сыр, горчица, кетчуп, лук, маринованные огурцы, острый соус",270.00);

        createProduct(categoryRepository.findByName("Острые бургеры"), "АвтоМаксиЧикен",
                "Куриная котлета, помидор, острый соус",329.00);

        createProduct(categoryRepository.findByName("Острые бургеры"), "АвтоБум",
                "Два бивштекса, халапенью, лук, маринованные огурчики, сыр",489.00);

        /* Товары категории Напитки */
        /* Товары подкатегории Газированные напитки */

        createProduct(categoryRepository.findByName("Газированные напитки"), "Спрайт",
                "1 литр",95.00);

        createProduct(categoryRepository.findByName("Газированные напитки"), "Пепси-кола",
                "1 литр",87.00);

        createProduct(categoryRepository.findByName("Газированные напитки"), "Миринда",
                "1 литр",110.00);

        /* Товары подкатегории Энергетические напитки */

        createProduct(categoryRepository.findByName("Энергетические напитки"), "Ред булл",
                "Черника/Кокос-ягоды 0.3 л.",210.00);

        createProduct(categoryRepository.findByName("Энергетические напитки"), "Gorilla",
                "Orange 0.45 л.",89.00);

        createProduct(categoryRepository.findByName("Энергетические напитки"), "Торнадо",
                "Кофеин/Актив/Айс 0.45 л.",55.00);

        /* Товары подкатегории Соки */

        createProduct(categoryRepository.findByName("Соки"), "Добрый",
                "Яблоко/Мультифрукт/Вишня/Апельсин 1 л.",155.00);

        createProduct(categoryRepository.findByName("Соки"), "Rich",
                "Яблоко/Мультифрукт/Вишня/Апельсин 1 л.",235.00);

        createProduct(categoryRepository.findByName("Соки"), "DaDa",
                "Яблоко/Мультифрукт/Вишня/Апельсин 1 л.",90.00);

        /* Товары подкатегории Другие */

        createProduct(categoryRepository.findByName("Другие"), "Пиво",
                "Хугарден, Эдельвейс, Кроненберг 1664 0.5 л.",230.00);

        createProduct(categoryRepository.findByName("Другие"), "Чай",
                "Черный/Зеленый/Фруктовый 1 л.",110.00);

        createProduct(categoryRepository.findByName("Другие"), "Лимонад",
                "Груша/Лимон/Фейхоа",120.00);
    }
}

