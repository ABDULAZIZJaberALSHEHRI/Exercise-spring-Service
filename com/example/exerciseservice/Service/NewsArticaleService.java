package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.NewsArticale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class NewsArticaleService {
    ArrayList<NewsArticale> newsArticaleList = new ArrayList<>();


    public ArrayList<NewsArticale> getNewsArticaleList() {
        return newsArticaleList;
    }

    public void addNewsArticale(NewsArticale newsArticale) {
        newsArticaleList.add(newsArticale);
    }

    public boolean updateNewsArticale(int id, NewsArticale newsArticale) {
        for (int i = 0; i < newsArticaleList.size(); i++) {
            if (newsArticaleList.get(i).getId() == id) {
                newsArticaleList.set(i, newsArticale);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNewsArticale(int id) {
        for (int i = 0; i < newsArticaleList.size(); i++) {
            if (newsArticaleList.get(i).getId() == id) {
                newsArticaleList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean published(int id) {
        for (NewsArticale newsArticale : newsArticaleList) {
            if (newsArticale.getId() == id) {
                newsArticale.setPublished(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<NewsArticale> getPublishedNewsArticles() {
        ArrayList<NewsArticale> published = new ArrayList<>();

        for (int i = 0; i < newsArticaleList.size() ; i++) {
            if (newsArticaleList.get(i).isPublished()) {
                 published.add(newsArticaleList.get(i));
            }
        }
        if (published.isEmpty()) {
            return null;
        }
   return published;
    }
    
    public ArrayList<NewsArticale> getByCategory(String category){
       ArrayList<NewsArticale> categories = new ArrayList<>();

        for (int i = 0; i < newsArticaleList.size(); i++) {

            if (newsArticaleList.get(i).getCategory().equalsIgnoreCase(category)) {
                categories.add(newsArticaleList.get(i));
            }

        }//if the list is empty or the searched category not found
        if (categories.isEmpty()){
            return null;
        }
        return categories;
    }

}
