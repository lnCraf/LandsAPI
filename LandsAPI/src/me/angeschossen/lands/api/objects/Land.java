package me.angeschossen.lands.api.objects;

import com.sun.istack.internal.NotNull;
import me.angeschossen.lands.api.enums.LandRole;
import me.angeschossen.lands.api.enums.LandsAction;
import me.angeschossen.lands.api.enums.LandsSetting;
import me.angeschossen.lands.api.enums.war.WarTeam;
import me.angeschossen.lands.api.objects.war.Nation;
import me.angeschossen.lands.api.objects.war.War;
import me.angeschossen.lands.api.objects.war.WarDeclaration;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public interface Land {

    /**
     * Apply default settings from
     * config to this land.
     */
    void applyDefaultSettings();


    /**
     * Get upkeep costs
     *
     * @return Upkeep costs
     */
    @NotNull
    double getUpkeepCosts();

    /**
     * Get name of the land
     * This value never changes
     *
     * @return Name of land without color
     */
    @NotNull
    String getName();

    /**
     * Get id of land.
     *
     * @return ID
     */
    @NotNull
    int getID();

    /**
     * Get land name with color.
     * @return Land name with color
     */
    @NotNull
    String getColoredName();

    /**
     * Get invite by receiver UUID
     *
     * @param receiverUUID UUID of receiver
     * @return Invite
     */
    @Nullable
    Invite getInvite(@NotNull UUID receiverUUID);

    /**
     * Get owner UUID of land
     *
     * @return UUID of owner
     */
    @NotNull
    UUID getOwnerUID();

    /**
     * Get spawn
     *
     * @return Spawn
     */
    @Nullable
    Location getSpawn();

    /**
     * Get name of world
     *
     * @return Name of world
     */
    @NotNull
    String getWorldName();

    /**
     * Get landWorld wich the land is in
     *
     * @return LandWorld
     */
    @NotNull
    LandWorld getLandWorld();

    /**
     * Get trusted players of this role.
     *
     * @param landRole Role
     * @return Trusted players of this role.
     */
    @NotNull
    Collection<TrustedPlayer> getTrustedPlayers(LandRole landRole);

    /**
     * Get role members.
     *
     * @param landRole Role
     * @return Members of this role.
     */
    @NotNull
    Collection<UUID> getRoleMembers(LandRole landRole);

    /**
     * Get the landRole of an player
     *
     * @param playerUUID UUID of player
     * @return LandRole
     */
    @NotNull
    LandRole getLandRole(@NotNull UUID playerUUID);

    /**
     * Get the size of an land
     *
     * @return Size of land
     */
    @NotNull
    int getSize();

    /**
     * Get tax value of land
     *
     * @return Tax value
     */
    @NotNull
    double getTax();

    /**
     * Get all invites sent by the land
     *
     * @return Invites
     */
    @NotNull
    Collection<Invite> getInvites();

    /**
     * Check if setting is enabled
     *
     * @param landsSetting LandsSetting
     * @return Boolean
     */
    boolean getSetting(@NotNull LandsSetting landsSetting);

    /**
     * Enable a setting
     *
     * @param landsSetting LandsSetting
     */
    void enableSetting(@NotNull LandsSetting landsSetting);

    /**
     * Disable a setting
     *
     * @param landsSetting LandsSetting
     */
    void disableSetting(@NotNull LandsSetting landsSetting);

    /**
     * Toggle a setting
     *
     * @param landsSetting LandsSetting
     * @return Result
     */
    boolean toggleSetting(@NotNull LandsSetting landsSetting);

    /**
     * Check if setting is enabled
     *
     * @param landsAction LandsAction
     * @param landRole    LandRole
     * @return Boolean
     */
    boolean getAction(@NotNull LandRole landRole, @NotNull LandsAction landsAction);

    /**
     * Enable an landsAction
     *
     * @param landsAction LandsAction
     * @param landRole    Role
     */
    void enableAction(@NotNull LandRole landRole, @NotNull LandsAction landsAction);

    /**
     * Disable an landsAction
     *
     * @param landsAction LandsAction
     * @param landRole    Role
     */
    void disableAction(@NotNull LandRole landRole, @NotNull LandsAction landsAction);

    /**
     * Toggle access for an action for a speficied role
     *
     * @param landRole    Role
     * @param landsAction Action
     * @return true if enabled, false if disabled
     */
    boolean toggleAction(@NotNull LandRole landRole, @NotNull LandsAction landsAction);

    /**
     * Set landRole for a player
     *
     * @param landPlayer LandPlayer wich you want to set
     * @return Will return false if fails because of max members permission.
     */
    boolean trustPlayer(@NotNull LandPlayer landPlayer);


    /**
     * Get max members.
     *
     * @return Max members
     */
    @NotNull
    int getMaxMembers();

    /**
     * Get max chunk claims.
     *
     * @return Max chunk claims
     */
    @NotNull
    int getMaxChunks();

    /**
     * Get all trusted players
     *
     * @return Trusted players
     */
    @NotNull
    Collection<UUID> getTrustedPlayers();

    /**
     * Set role of trusted player.
     *
     * @param playerUUID UUID of player
     * @param landRole   Role
     */
    void setRole(@NotNull UUID playerUUID, @NotNull LandRole landRole);

    /**
     * Force-trust a player. Ignoring max members etc.
     *
     * @param landPlayer Player
     */
    void trustPlayerForced(@NotNull LandPlayer landPlayer);

    /**
     * Set the tax of the land
     *
     * @param tax Tax value
     */
    void setTax(@NotNull double tax);

    /**
     * Check is land loaded
     *
     * @return Boolean
     */
    @NotNull
    boolean isLoaded();


    /**
     * Get all chunkCoords of an land
     *
     * @return Collection of chunkCoords
     */
    @NotNull
    Set<ChunkCoordinate> getChunkCoordinates();

    /**
     * Set title message.
     *
     * @param title Message
     */
    void setTitleMessage(@NotNull String title);

    /**
     * Get title mesasage.
     *
     * @return Title message.
     */
    @NotNull
    String getTitleMessage();

    /**
     * Set an new owner for land
     *
     * @param landPlayer LandPlayer for new owner
     */
    void setOwner(@NotNull LandPlayer landPlayer);

    /**
     * Untrust an player
     *
     * @param landPlayer LandPlayer wich should be untrusted
     */
    void untrustLandPlayer(@NotNull LandPlayer landPlayer);

    /**
     * Check if land has a chunk
     *
     * @param worldName Name of world
     * @param x         X of chunk
     * @param z         Z of chunk
     * @return true if has
     */
    boolean hasChunk(@NotNull String worldName, @NotNull int x, @NotNull int z);

    /**
     * Set name of land
     *
     * @param name New name
     */
    void setName(@NotNull String name);

    /**
     * Check if player is trusted in whole land.
     *
     * @param playerUUID UUID of player
     * @return true if is
     */
    @NotNull
    boolean isTrusted(@NotNull UUID playerUUID);

    /**
     * Get a collection of all online land members
     *
     * @return Collection of online players
     */
    @NotNull
    Collection<LandPlayer> getOnlinePlayers();

    /**
     * Check if player can action
     *
     * @param playerUUID UUID of player
     * @param action     Action
     * @return Result
     */
    boolean canAction(@NotNull UUID playerUUID, @NotNull LandsAction action);

    /**
     * Check if player can action with checking bypass permission
     * This will send a message to the player if he can't access the action and has no required bypass permission.
     * @param player Player
     * @param action Action
     * @param sendMessage Send message?
     * @return Will return false if player has no access and has no bypass permission
     */
    boolean canAction(@NotNull Player player, @NotNull LandsAction action, @NotNull boolean sendMessage);

    /**
     * Check if player can action.
     *
     * @param playerUUID UUID of player
     * @param action     Action
     * @return Result
     */
    boolean canActionGlobal(@NotNull UUID playerUUID, @NotNull LandsAction action);

    /**
     * Get last claimed chunk.
     *
     * @return Coordinate
     */
    @Nullable
    ChunkCoordinate getLastClaimed();

    /**
     * Get trusted player.
     *
     * @param playerUUID UID of player.
     * @return Trusted player
     */
    @Nullable
    TrustedPlayer getTrustedPlayer(@NotNull UUID playerUUID);

    /**
     * Does land exist?
     *
     * @return boolean
     */
    boolean exists();

    /**
     * Add tax value. Use negative numbers
     * to remove tax.
     *
     * @param value Tax value
     * @return Result
     */
    double addTax(@NotNull double value);


    /**
     * Set spawn location of land
     *
     * @param location Location of spawn
     */
    void setSpawn(@Nullable Location location);


    /**
     * Get land balance
     *
     * @return Balance
     */
    @NotNull
    double getBalance();

    /**
     * Set land bank balance
     *
     * @param balance Value
     */
    void setBalance(@NotNull double balance);

    /**
     * Add money to land bank. Use negative numbers
     * to remove money.
     *
     * @param value Value
     * @return
     */
    double addBalance(@NotNull double value);

    /**
     * Set the nation for the land
     * @param nation New nation
     */
    void setNation(@Nullable Nation nation);

    /**
     * Get the nation
     * @return Nation or null, if land is not member of a nation
     */
    @Nullable
    Nation getNation();

    /**
     * Get the current war of the land.
     * A land can only be engaged in one war at the same time.
     * @return War or null, if land is in no war.
     */
    @Nullable
    War getWar();

    /**
     * Leave the current war
     */
    void leaveWar();

    /**
     * Is the land in a war?
     * @return true, if land is in a war.
     */
    boolean isInWar();

    /**
     * Join a war.
     * @param war War
     * @param warTeam ATTACKER or DEFENDER
     */
    void joinWar(@NotNull War war, @NotNull WarTeam warTeam);

    /**
     * Get the team of current war.
     * @return Team
     */
    WarTeam getWarTeam();

    /**
     * Add time to the war shield.
     * @param seconds Seconds
     */
    void addWarShieldTime(@NotNull long seconds);

    /**
     * Check if the land has an active war shield
     * @return true, if land has war shield.
     */
    boolean hasWarShield();

    /**
     * Get the lands current
     * war declaration.
     * @return War declaration, or null if none received.
     */
    @Nullable
    WarDeclaration getWarDeclaration();

    /**
     * Has the land a war declaration?
     * @return true, if land has war declaration.
     */
    boolean hasWarDeclaration();

}
