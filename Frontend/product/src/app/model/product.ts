export interface Product {
  id: number;
  name: string;
  description: string;
  categoryName: string;
  imageFile: string;
  price: string;
  size: string; // replaced "unitOfMeasure" with "size"
}
