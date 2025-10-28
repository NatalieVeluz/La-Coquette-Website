import { Component } from '@angular/core';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css'],
  standalone: false
})
export class ContactUsComponent {
  brand = 'La Coquette';

  hero = {
    title: 'About Our Fashion Journey',
    description: `At La Coquette, we blend elegance, confidence, and femininity. 
    Since 2020, our passion for timeless fashion has inspired collections 
    that empower women to embrace their individuality and beauty.`,
    stats: [
      { value: '1K+', label: 'Happy Customers' },
      { value: '200+', label: 'Exclusive Designs' },
      { value: '5', label: 'Years of Style' }
    ],
    image:
      'https://i.pinimg.com/1200x/2d/15/f7/2d15f72f416ca0f8e43f75a7795bb20c.jpg'
  };

  values = [
    {
      icon: 'fas fa-heart',
      title: 'Elegance',
      text: 'We believe true beauty is confidence, grace, and authenticity.'
    },
    {
      icon: 'fas fa-hand-sparkles',
      title: 'Quality',
      text: 'Each piece is crafted with care to ensure comfort and lasting beauty.'
    },
    {
      icon: 'fas fa-users',
      title: 'Empowerment',
      text: 'We celebrate individuality and empower every woman to shine.'
    }
  ];

  team = [
    {
      name: 'Natalie Joy D. Veluz',
      role: 'Founder & Designer',
      desc: 'Passionate about blending art and fashion since day one.',
      img: 'https://i.pinimg.com/1200x/b0/ac/f1/b0acf1b7e2f9e4ca0d0320374005c00e.jpg'
    },
    {
      name: 'Frances Gabrielle B. Sagban',
      role: 'Creative Director',
      desc: 'Brings innovative ideas to life with every collection.',
      img: 'https://i.pinimg.com/736x/2a/7d/4c/2a7d4c4bc1381a476b8b8a85885ac392.jpg'
    },
    {
      name: 'Alexa D.Cruz',
      role: 'Marketing Lead',
      desc: 'Connects our brand with fashion lovers worldwide.',
      img: 'https://i.pinimg.com/736x/40/2f/e4/402fe4473f1b29109259566ee004bf96.jpg'
    }
  ];

  gallery = [
    'https://i.pinimg.com/1200x/11/a1/2d/11a12d435f954835ae17d1a88032ece8.jpg',
    'https://i.pinimg.com/736x/83/67/4d/83674dfad6e312cf04bf3c3ae041e19a.jpg',
    'https://i.pinimg.com/736x/86/8d/5e/868d5ebd4fad189e82b740f2d8fbb089.jpg',
    'https://i.pinimg.com/736x/6e/b5/34/6eb534616c42eb245f4a6c3dd1bd0aec.jpg'
  ];

  story = {
    title: 'Our Story',
    text: `La Coqoutte was born from a love for timeless beauty, femininity, and self-expression.
    What started as a simple idea—to create pieces that make every woman feel confident and 
    effortlessly elegant—soon blossomed into a brand that celebrates individuality and charm. 
    Every detail, from our designs to our packaging, is thoughtfully crafted to capture the 
    essence of sophistication with a modern touch. At La Coqoutte, we believe that beauty isn’t 
    just about how you look—it’s about how you feel. Our mission is to inspire confidence, 
    embrace softness, and empower women to express their true selves through every piece we create.`
  };

  submitForm() {
    alert('Thank you for reaching out! We’ll get back to you soon 💌');
  }
}
