package za.ac.cput.service.wishlist;


import za.ac.cput.domain.Wishlist;
import za.ac.cput.service.IService;

import java.util.List;

public interface IWishlistService extends IService<Wishlist, Long> {
    List<Wishlist> getAll();
}
