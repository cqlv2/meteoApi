package dev.utils.transformer;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.city.CityDtoQuery;
import dev.dto.comment.CommentDtoQuery;
import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.member.MemberDtoQuery;
import dev.dto.polluant.PolluantDtoQuery;
import dev.dto.subject.SubjectDtoQuery;
import dev.dto.topic.TopicDtoQuery;
import dev.dto.weather.WeatherDtoQuery;
import dev.entity.*;

/**
 * referral tool for the use of the transformer corresponding to the entity's
 * class
 *
 * @author cql-v2
 * @author louise
 * @version 1.0
 */
public class SuperTransformer {

    /**
     * @param entity entity to be referred
     * @return an entity transform into DTO response
     */
    public static Object entityToDtoResponse(SuperEntity entity) {
        switch (entity.getClass().getSimpleName()) {

            case "Member":
                return MemberTransformer.entityToDtoResponse((Member) entity);

            case "Role":
                return RoleTransformer.entityToDtoResponse((Role) entity);

            case "Right":
                return RightTransformer.entityToDtoResponse((Right) entity);

            case "Favorite":
                return FavoriteTransformer.entityToDtoResponse((Favorite) entity);

            case "ForumAnswer":
                return ForumAnswerTransformer.entityToDtoResponse((ForumAnswer) entity);

            case "ForumComment":
                return ForumCommentTransformer.entityToDtoResponse((ForumComment) entity);

            case "ForumSubject":
                return ForumSubjectTransformer.entityToDtoResponse((ForumSubject) entity);

            case "ForumTopic":
                return ForumTopicTransformer.entityToDtoResponse((ForumTopic) entity);

            case "City":
                return CityTransformer.entityToDtoResponse((City) entity);

            case "Weather":
                return WeatherTransformer.entityToDtoResponse((Weather) entity);

            case "Polluant":
                return PolluantTransformer.entityToDtoResponse((Polluant) entity);

            default:
                // TODO gérer une exception
                return null;
        }

    }

    public static Object dtoToEntity(Object dtoQuery) {
        switch (dtoQuery.getClass().getSimpleName()) {

            case "MemberDtoQuery":
                return MemberTransformer.dtoToEntity((MemberDtoQuery) dtoQuery);

            case "FavoriteDtoQuery":
                return FavoriteTransformer.dtoToEntity((FavoriteDtoQuery) dtoQuery);

            case "AnswerDtoQuery":
                return ForumAnswerTransformer.dtoToEntity((AnswerDtoQuery) dtoQuery);

            case "CommentDtoQuery":
                return ForumCommentTransformer.dtoToEntity((CommentDtoQuery) dtoQuery);

            case "SubjectDtoQuery":
                return ForumSubjectTransformer.dtoToEntity((SubjectDtoQuery) dtoQuery);

            case "TopicDtoQuery":
                return ForumTopicTransformer.dtoToEntity((TopicDtoQuery) dtoQuery);

            case "CityDtoQuery":
                return CityTransformer.dtoToEntity((CityDtoQuery) dtoQuery);

            case "WeatherDtoQuery":
                return WeatherTransformer.dtoToEntity((WeatherDtoQuery) dtoQuery);

            case "PolluantDtoQuery":
                return  PolluantTransformer.dtoToEntity((PolluantDtoQuery) dtoQuery);

            default:
                //TODO gérer une exception
                return null;
        }
    }

}
