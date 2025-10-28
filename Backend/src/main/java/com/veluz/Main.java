package com.veluz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import com.veluz.entity.Product;
import com.veluz.repository.ProductRepository;

import java.time.Instant;
import java.util.List;

@SpringBootApplication(
        exclude = {
                SecurityAutoConfiguration.class,
                UserDetailsServiceAutoConfiguration.class
        }
)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {

                List<Product> products = List.of(

                        // TOPS
                        new Product(
                                null,
                                "Plaid Bow Babydoll Top",
                                "This cute and chic babydoll top features a timeless plaid pattern that adds a touch of sophistication to any outfit. Its lightweight fabric ensures comfort and breathability, making it perfect for casual outings or brunch dates. The top is designed with a flattering fit that flows gently from the bust down, creating an elegant silhouette. The bow detail at the front adds a charming feminine touch that elevates the overall look. Pair it with high-waisted jeans or a skirt for a versatile ensemble that can easily transition from day to night. This top is a must-have for those who love classic style with a playful twist.",
                                "Tops",
                                "S",
                                "1 Plaid Bow",
                                850.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Floral Ruffle Camisole",
                                "This delicate camisole showcases a soft floral print accented with playful ruffles along the neckline and hem. The lightweight material drapes beautifully, creating a feminine and breezy silhouette. Perfect for layering under jackets or cardigans, this camisole adds a romantic touch to any outfit. The adjustable straps ensure a comfortable fit tailored to your body shape. Ideal for casual daywear or summer evenings, pair it with skirts or tailored trousers for a chic and effortless look. Its versatility makes it a staple in any wardrobe.",
                                "Tops",
                                "M",
                                "2 Floral Ruffle",
                                780.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Pink Corset Crop Top",
                                "Make a bold statement with this trendy pink corset-style crop top. Featuring structured boning and a sweetheart neckline, it accentuates the waist while offering a fashionable, modern look. The soft yet durable fabric ensures comfort while maintaining shape, perfect for day-to-night outfits. Pair it with high-waisted skirts or jeans for a balanced, stylish ensemble. Ideal for parties, casual outings, or date nights, this top adds a playful and edgy charm to your wardrobe, making you stand out wherever you go.",
                                "Tops",
                                "S",
                                "3 Pink Corset",
                                900.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Ribbon Flower Print Tank",
                                "This sleeveless tank is adorned with a charming ribbon flower design that brings a touch of elegance to casual wear. The soft fabric drapes smoothly, offering both comfort and style. Its versatile design makes it perfect for pairing with jeans, skirts, or shorts for a relaxed yet polished look. The playful print adds vibrancy to your everyday outfits. Suitable for warm weather or layering under jackets, this tank combines fashion and functionality effortlessly. Its feminine details make it a standout addition to your wardrobe.",
                                "Tops",
                                "M",
                                "4 Ribbon Flower",
                                750.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Ballet Bow Lace Tee",
                                "This elegant lace tee features a delicate ballet bow at the neckline, combining sophistication with feminine charm. The soft lace overlay offers a textured, luxurious feel that elevates everyday outfits. Designed to fit comfortably while highlighting subtle details, this tee is perfect for layering or wearing alone. The classic silhouette pairs well with skirts, jeans, or tailored trousers. Its romantic design makes it suitable for brunches, date nights, or casual gatherings, offering a timeless and chic addition to your wardrobe.",
                                "Tops",
                                "L",
                                "5 Ballet Bow",
                                800.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Knot Front Floral Top",
                                "This floral top features a trendy knot front design that adds a modern twist to a classic print. Its lightweight material and flowy fit make it ideal for everyday wear, offering both comfort and style. The vibrant floral pattern enhances its playful appeal, while the knot detail emphasizes the waistline for a flattering silhouette. Pair it with jeans, shorts, or skirts for versatile styling options. Perfect for casual outings or semi-formal events, this top blends contemporary fashion with feminine charm seamlessly.",
                                "Tops",
                                "M",
                                "6 Knot Front",
                                820.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Lace Ruched Choker Blouse",
                                "This choker-style blouse features intricate lace and ruched details for a sophisticated, stylish look. The lightweight fabric ensures comfort while adding texture and elegance to your ensemble. Its fitted silhouette combined with choker neckline creates a fashionable statement piece that works well with skirts or tailored trousers. The delicate lace provides a timeless and refined aesthetic. Ideal for dinner dates, parties, or special occasions, this blouse is a versatile addition to any wardrobe seeking elegance with modern flair.",
                                "Tops",
                                "S",
                                "7 Lace Ruched",
                                880.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Off-Shoulder Butterfly Top",
                                "This off-shoulder top features a charming butterfly print that brings a whimsical touch to your wardrobe. The airy fabric ensures comfort while flattering your neckline and shoulders. Its versatile design pairs perfectly with high-waisted skirts, shorts, or jeans for an effortless, chic look. The off-shoulder style adds a playful yet elegant appeal. Ideal for casual outings, parties, or summer gatherings, this top is a feminine and stylish choice for those who love delicate prints with a contemporary twist.",
                                "Tops",
                                "M",
                                "8 Off-Shoulder",
                                900.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        // BOTTOMS
                        new Product(
                                null,
                                "Tie-Dye A-Line Skirt",
                                "Bring playful vibes to your wardrobe with this tie-dye A-line skirt. The soft fabric flows effortlessly while creating a flattering silhouette for all body types. Its vibrant pattern ensures it stands out as a statement piece, perfect for pairing with neutral tops or casual tees. The comfortable waistband allows ease of movement for day-long wear. Ideal for casual outings, festivals, or summer events, this skirt adds a fun and stylish touch to any outfit. It combines comfort with a trendy aesthetic seamlessly.",
                                "Bottoms",
                                "M",
                                "9 Tie-Dye",
                                850.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Lace-Up Ruffle Skirt",
                                "This ruffled skirt with lace-up detail exudes femininity and charm. The flowing fabric and layered ruffles create movement and texture, making it perfect for a chic and playful look. The lace-up front adds a touch of elegance while allowing you to adjust the fit for maximum comfort. It pairs beautifully with fitted tops or blouses to balance the overall silhouette. Perfect for brunch dates, casual strolls, or semi-formal occasions, this skirt is a versatile addition that elevates your outfit effortlessly.",
                                "Bottoms",
                                "S",
                                "10 Lace-Up",
                                880.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Layered Tulle Skirt",
                                "Add a romantic flair to your wardrobe with this layered tulle skirt. The voluminous layers create a dreamy, princess-like silhouette while remaining lightweight and comfortable. Its delicate construction makes it ideal for special occasions, parties, or even casual chic looks when paired with a simple top. The soft waistband ensures a comfortable fit throughout the day. Combine it with elegant blouses or playful cropped tops for versatile styling. This skirt brings a touch of whimsy and elegance to any outfit.",
                                "Bottoms",
                                "M",
                                "11 Layered Tulle",
                                1000.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Bowknot A-Line Mini Skirt",
                                "This mini skirt features a charming bowknot design at the waist for a playful and feminine touch. Its A-line silhouette offers a flattering fit while allowing ease of movement. Made from soft and durable fabric, it is perfect for day-to-day wear or casual outings. Pair it with crop tops, blouses, or graphic tees for a stylish ensemble. Ideal for casual parties, brunches, or weekend hangouts, this skirt adds a youthful and chic flair to your wardrobe.",
                                "Bottoms",
                                "S",
                                "12 Bowknot",
                                900.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Belted Wide-Leg Pants",
                                "These wide-leg pants with belt accents bring a sophisticated and modern look to your outfit. The high-waisted design elongates your legs while offering a comfortable and relaxed fit. The stylish belt accent highlights the waist, allowing for a polished silhouette. Perfect for office wear or semi-formal occasions, they pair well with blouses or fitted tops. Crafted for comfort and elegance, these pants are versatile staples that can elevate both casual and professional looks effortlessly.",
                                "Bottoms",
                                "L",
                                "13 Belted Wide",
                                1100.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Lace-Up Wide-Leg Jeans",
                                "These wide-leg jeans feature trendy lace-up sides that add an edgy twist to a classic silhouette. The relaxed fit ensures comfort while maintaining a fashionable look. The stylish lace-up design enhances the overall aesthetic, making these jeans suitable for casual outings, gatherings, or streetwear-inspired ensembles. Pair with crop tops or fitted blouses for balance. A modern essential, these jeans combine comfort and style seamlessly, perfect for anyone looking to make a statement with everyday wear.",
                                "Bottoms",
                                "M",
                                "14 Lace-Up Wide-Leg",
                                1200.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Flared Rhinestone Jeans",
                                "These flared jeans are decorated with sparkling rhinestones, creating a glamorous and eye-catching look. The flared silhouette balances your proportions while offering comfort and mobility. Perfect for evening events, parties, or casual chic outfits, these jeans pair beautifully with fitted tops or blouses. The rhinestone detailing adds a luxurious touch to any ensemble. Make a statement with these jeans that combine bold fashion with everyday wearability, ensuring you stand out effortlessly.",
                                "Bottoms",
                                "L",
                                "15 Flared Rhinestone",
                                1300.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Cake-Hem Denim Mini Skirt",
                                "This playful denim mini skirt features a unique cake-hem design that adds texture and character to your outfit. The A-line shape ensures a flattering fit while offering freedom of movement. The soft denim fabric is durable and comfortable, perfect for everyday wear. Pair it with casual tops, tees, or blouses for versatile styling options. Ideal for weekend outings, casual events, or summer adventures, this mini skirt adds fun and charm to your wardrobe while keeping a trendy edge.",
                                "Bottoms",
                                "S",
                                "16 Cake-Hem",
                                950.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        // DRESSES
                        new Product(
                                null,
                                "Bowknot Strap Cami Dress",
                                "This cami dress features delicate bowknot straps for a charming and feminine look. The lightweight material drapes elegantly, creating a flattering silhouette suitable for any occasion. Its versatile design makes it perfect for both casual and semi-formal events. Pair it with sandals for a day look or heels for evening outings. The bowknot straps add a playful touch to its classic style. A wardrobe essential for those seeking effortless elegance, this dress is both comfortable and stylish.",
                                "Dresses",
                                "S",
                                "17 Bowknot Strap",
                                1200.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Vintage Lace Ruffle Dress",
                                "Elegant and timeless, this vintage lace dress features delicate ruffles that add texture and sophistication. The fitted bodice and flowing skirt create a flattering silhouette for any body type. Its soft lace material ensures comfort while exuding charm and refinement. Perfect for brunches, tea parties, or romantic evenings, it pairs well with delicate accessories. The dress balances classic design with modern elegance, making it a standout piece for anyone looking to add romance to their wardrobe.",
                                "Dresses",
                                "M",
                                "18 Vintage Lace",
                                1250.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Pink Floral Retro Dress",
                                "This retro-inspired dress is adorned with a lovely pink floral pattern, exuding a playful and feminine vibe. The fitted waist and flared skirt create a flattering silhouette suitable for various occasions. Soft, breathable fabric ensures all-day comfort, while the classic design brings a nostalgic charm to your outfit. Pair with flats or heels for versatile styling options. Perfect for garden parties, casual events, or brunch dates, this dress adds a cheerful and elegant touch to your wardrobe.",
                                "Dresses",
                                "S",
                                "19 Pink Floral",
                                1100.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Sweetheart Layered Flower Dress",
                                "This romantic layered dress features a sweetheart neckline and layered floral detailing, creating a dreamy and elegant look. The flowing skirt adds volume and movement, perfect for special occasions. Its lightweight fabric ensures comfort while enhancing its sophisticated charm. Pair with delicate accessories and heels for a refined ensemble suitable for weddings, parties, or date nights. A statement piece that combines elegance and femininity, this dress is a must-have for any wardrobe seeking timeless beauty.",
                                "Dresses",
                                "M",
                                "20 Sweetheart Layered",
                                1300.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Bow Knot Strapless Midi Dress",
                                "This elegant strapless midi dress features a bow knot detail, combining sophistication with a touch of playfulness. The fitted bodice accentuates the waist, while the flowing skirt adds graceful movement. Ideal for formal occasions, parties, or evening events, its versatile design allows pairing with heels and minimal accessories. The bow knot adds charm without overpowering the classic silhouette. Perfect for making a statement, this dress balances elegance and style effortlessly.",
                                "Dresses",
                                "S",
                                "21 Bow Knot Strapless",
                                1400.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Vintage Floral Bustier Dress",
                                "This bustier dress features vintage floral prints for a timeless and feminine appeal. The structured bodice offers support and shape, while the flowing skirt adds elegance and grace. Its breathable fabric ensures comfort for daytime or evening wear. Pair with heels and subtle accessories for an effortlessly chic look suitable for weddings, brunches, or parties. A perfect blend of retro charm and modern elegance, this dress elevates any wardrobe with style and sophistication.",
                                "Dresses",
                                "M",
                                "22 Vintage Floral",
                                1350.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Halter Neck Layered Dress",
                                "This stylish halter neck dress features layered details that create texture and movement for a flattering and modern look. The neckline draws attention to the shoulders and collarbones, enhancing the silhouette. Its lightweight fabric ensures comfort while maintaining a chic appearance, perfect for casual outings or semi-formal events. Pair with heels or flats depending on the occasion. A versatile and elegant addition to your wardrobe, this dress combines contemporary design with timeless appeal.",
                                "Dresses",
                                "S",
                                "23 Halter Neck",
                                1250.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        ),

                        new Product(
                                null,
                                "Mesh Flare Sleeve Dress",
                                "This elegant dress features mesh flare sleeves and a flowing silhouette that exudes sophistication. The soft fabric drapes beautifully, offering comfort and style for various occasions. The mesh sleeves add a delicate, feminine touch, while the classic design ensures versatility. Pair with heels or flats for daytime or evening events. Ideal for parties, special occasions, or semi-formal gatherings, this dress combines charm and elegance in a modern, wearable design.",
                                "Dresses",
                                "M",
                                "24 Mesh Flare",
                                1300.00,
                                100,
                                1,
                                Instant.now(),
                                Instant.now()
                        )
                );

                productRepository.saveAll(products);
                System.out.println("24 default products added to database successfully!");
            } else {
                System.out.println("ℹProducts already exist in database, skipping insert.");
            }
        };
    }
}
