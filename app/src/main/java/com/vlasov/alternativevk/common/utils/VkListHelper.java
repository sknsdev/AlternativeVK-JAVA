package com.vlasov.alternativevk.common.utils;

import com.vlasov.alternativevk.model.Owner;
import com.vlasov.alternativevk.model.WallItem;
import com.vlasov.alternativevk.rest.model.response.ItemWithSendersResponce;

import java.util.List;

public class VkListHelper {
    public static List<WallItem> getWallList(ItemWithSendersResponce<WallItem> response) {
        List<WallItem> wallItems = response.items;

        for (WallItem wallItem : wallItems) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            wallItem.setAttachmentsString(Utils.convertAttachmentsToFontIcons(wallItem.getAttachments()));


            if (wallItem.haveSharedRepost()) {//тут
           Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
           wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
           wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());

                wallItem.getSharedRepost().setAttachmentsString(Utils.convertAttachmentsToFontIcons(
                        wallItem.getSharedRepost().getAttachments()
                ));

       }
        }
        return wallItems;
    }
}