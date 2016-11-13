package com.example.dell.dbtest;

/**
 * Created by dell on 2016/11/2.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.example.dell.dbtest.Models.StoryModel;
import com.example.dell.dbtest.Models.UserModel;


public class ResultParser
{
    // Bu Hao De Fang Fa!!!
    public static ArrayList<UserModel> parseUser(String response)throws Exception
    {
        ArrayList<UserModel> result = new ArrayList<>();
        if(!response.isEmpty())
        {
            String[] array = response.split(";");
            if(array.length>11)
            {
                int i = 0;
                int count = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
                UserModel model = new UserModel();
                int length = array.length;
                //12
                while(i<length)
                {
                    String str = array[i++];
                    String[] strs = str.split("=");
                    if(strs.length == 2)
                    {
                        switch (count)
                        {
                            case 0:
                                count++;
                                model.user_id = strs[1];
                                break;
                            case 1:
                                count++;
                                model.nickname = strs[1];
                                break;
                            case 2:
                                count++;
                                model.slogan = strs[1];
                                break;
                            case 3:
                                count++;
                                model.avatar = strs[1];
                                break;
                            case 4:
                                count++;
                                model.birthday = new java.util.Date();
                                model.birthday = sdf.parse(strs[1]);
                                break;
                            case 5:
                                count++;
                                model.occupation = strs[1];
                                break;
                            case 6:
                                count++;
                                model.gender = strs[1].charAt(0);
                                break;
                            case 7:
                                count++;
                                model.address = strs[1];
                                break;
                            case 8:
                                count++;
                                model.grade = Integer.parseInt(strs[1]);
                                break;
                            case 9:
                                count++;
                                model.coin = Integer.parseInt(strs[1]);
                                break;
                            case 10:
                                count++;
                                model.contribution = Integer.parseInt(strs[1]);
                                break;
                            case 11:
                                count = 0;
                                model.password = strs[1];
                                break;
                            default:
                                break;

                        }
                    }
                    result.add(model);
                }


            }
            else
            {

            }
        }
        return result;
    }


    public static ArrayList<StoryModel> parseStory(String response)throws Exception
    {
        ArrayList<StoryModel> result = new ArrayList<>();
        if(!response.isEmpty())
        {
            String[] array = response.split(";");
            if(array.length>3)
            {
                int i = 0;
                int count = 0;
                StoryModel model = new StoryModel();
                int length = array.length;
                //12
                while(i<length)
                {
                    String str = array[i++];
                    String[] strs = str.split("=");
                    if(strs.length == 2)
                    {
                        switch (count)
                        {
                            case 0:
                                count++;
                                model.story_id = strs[1];
                                break;
                            case 1:
                                count++;
                                model.user_id = strs[1];
                                break;
                            case 2:
                                count++;
                                model.title = strs[1];
                                break;
                            case 3:
                                count = 0;
                                model.content = strs[1];
                                break;
                            default:
                                break;

                        }
                    }
                    result.add(model);
                }


            }
            else
            {

            }
        }


        return result;
    }
}






/*public static ArrayList<UserModel> parseUser(String string)throws Exception
    {
        ArrayList<UserModel> result = null;
        UserModel model = new UserModel();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

        ByteArrayInputStream is = new ByteArrayInputStream(string.getBytes());
        XmlPullParser xpp = Xml.newPullParser();
        xpp.setInput(is,"UTF-8");
        int eventType = xpp.getEventType();
        int count = 1;
        //int max = 12;
        while(eventType != XmlPullParser.END_DOCUMENT)
        {
            switch (eventType)
            {
                case XmlPullParser.START_DOCUMENT:
                    result = new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if(xpp.getName().equals("string"))
                    {
                        switch (count)
                        {
                            /*case 1:  // user_id
                                eventType = xpp.next();
                                model.user_id = xpp.getText();
                                count++;
                                break;
                            case 2:  // nickname
                                eventType = xpp.next();
                                model.nickname = xpp.getText();
                                count++;
                                break;
                            case 3:  // slogan
                                eventType = xpp.next();
                                model.slogan = xpp.getText();
                                count++;
                                break;
                            case 4:  // avatar
                                eventType = xpp.next();
                                model.avatar = xpp.getText();
                                count++;
                                break;
                            case 5:  // birthday
                                eventType = xpp.next();
                                model.birthday = new java.util.Date();
                                model.birthday = sdf.parse(xpp.getText());
                                count++;
                                break;
                            case 6:  // occupation
                                eventType = xpp.next();
                                model.occupation = xpp.getText();
                                count++;
                                break;
                            case 7:  // gender
                                eventType = xpp.next();
                                model.gender = xpp.getText().charAt(0);
                                count++;
                                break;
                            case 8:  // address
                                eventType = xpp.next();
                                model.address = xpp.getText();
                                count++;
                                break;
                            case 9:  // grade
                                eventType = xpp.next();
                                model.grade = Integer.parseInt(xpp.getText());
                                count++;
                                break;
                            case 10:  // coin
                                eventType = xpp.next();
                                model.coin = Integer.parseInt(xpp.getText());
                                count++;
                                break;
                            case 11:  // contribution
                                eventType = xpp.next();
                                model.contribution = Integer.parseInt(xpp.getText());
                                count++;
                                break;
                            case 12:  // password
                                eventType = xpp.next();
                                model.password = xpp.getText();
                                count = 0;
                                result.add(model);
                                break;
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    break;
            }
            eventType = xpp.next();
        }
        return result;

    }*/